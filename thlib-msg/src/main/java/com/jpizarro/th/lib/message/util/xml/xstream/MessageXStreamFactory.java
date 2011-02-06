package com.jpizarro.th.lib.message.util.xml.xstream;

import com.jpizarro.th.lib.generic.util.exception.THException;
import com.jpizarro.th.lib.generic.util.xml.xstream.CalendarConverter;
import com.jpizarro.th.lib.generic.util.xml.xstream.XStreamFactory;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageXStreamFactory implements XStreamFactory
{
	public XStream createXStream()
	{
//		XStream xstream = new XStream(new DomDriver());
		XStream xstream = new XStream(new XppDriver());
		
		xstream.registerConverter(new CalendarConverter(), XStream.PRIORITY_VERY_HIGH);
//		xstream.registerConverter(new JoinedConverter(), XStream.PRIORITY_NORMAL);
		
		xstream.alias("msg", com.jpizarro.th.lib.message.entity.MessageTO.class);
		
		xstream.alias("exception", THException.class);
		
		return xstream;
	}

}
