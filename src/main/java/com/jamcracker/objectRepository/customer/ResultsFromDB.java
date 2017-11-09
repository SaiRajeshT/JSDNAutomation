package com.jamcracker.objectRepository.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.jamcracker.utilities.SQLUtil;

public class ResultsFromDB {

	public static String getOfferID(String offerCode) throws Exception {
		long offerID = 0;
		Connection con = SQLUtil.getConnection();
		DatabaseMetaData dbMetaData = con.getMetaData();
		String productType = dbMetaData.getDatabaseProductName();
		if (con != null) {
			String query = null;
			if (productType.equals("PostgreSQL")) {
				query = "select offer_id from jcp_service_offer_b where offer_code = ?";
			} else {
				query = "select offer_id from jcp_service_offer_b where offer_code = ?";
			}

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, offerCode);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				offerID = rs.getInt("offer_id");
			}
			SQLUtil.closeResultSet(rs);
			SQLUtil.closePreparedStatement(stmt);
		}
		SQLUtil.closeConnection(con);
		return Long.toString(offerID);
	}

	public static Map<String,String> getOrderNumber(String customerEmail, String offerCode) throws Exception {
		
		Map<String, String> orderData = new HashMap<String, String>();
		Connection con = SQLUtil.getConnection();
		DatabaseMetaData dbMetaData = con.getMetaData();
		String productType = dbMetaData.getDatabaseProductName();
		if (con != null) {
			String query = null;
			if (productType.equals("PostgreSQL")) {
				query = "select dtl.order_type,dtl.sc_ordr_id from jcp_sc_ordr_dtl dtl inner join jcp_sc_ordr ord on dtl.sc_ordr_id = ord.sc_ordr_id inner join jcp_service_offer_b ser on ser.offer_id = dtl.offer_id inner join jcp_organization org on org.actor_id = ord.organization_id and dtl.order_type is not null where org.contact_mail = ? and ser.offer_code = ? order by ord.sc_ordr_id " ;
			} else {
				query = "select dtl.order_type,dtl.sc_ordr_id from jcp_sc_ordr_dtl dtl inner join jcp_sc_ordr ord on dtl.sc_ordr_id = ord.sc_ordr_id inner join jcp_service_offer_b ser on ser.offer_id = dtl.offer_id inner join jcp_organization org on org.actor_id = ord.organization_id and dtl.order_type is not null where org.contact_mail = ? and ser.offer_code = ? order by ord.sc_ordr_id " ;
			}
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, customerEmail);
			stmt.setString(2, offerCode);
			
			ResultSet rs = stmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				if (rs.getString("order_type").equals("OM")) {
					orderData.put(rs.getString("order_type")+i++, rs.getString("sc_ordr_id"));
				} else {
					orderData.put(rs.getString("order_type"), rs.getString("sc_ordr_id"));
				}
			}
			SQLUtil.closeResultSet(rs);
			SQLUtil.closePreparedStatement(stmt);
		}
		SQLUtil.closeConnection(con);
	
		return orderData;
	}

}
