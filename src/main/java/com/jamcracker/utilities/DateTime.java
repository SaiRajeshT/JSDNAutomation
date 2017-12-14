package com.jamcracker.utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTime {

	//Following date format is mostly used while creating the screenshot. This format will be appended to the file name.
		private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		public String getDateTime(){		
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			return sdf.format(timestamp);
		}
}
