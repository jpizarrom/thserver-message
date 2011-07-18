package com.jpizarro.th.server.message.view.web.ws;

import org.apache.wicket.PageParameters;
//import org.wicketstuff.annotation.mount.MountPath;
//import org.wicketstuff.annotation.strategy.MountMixedParam;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.lib.message.util.xml.xstream.MessageXStreamFactory;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
import com.jpizarro.th.server.message.model.service.MessageService;
import com.jpizarro.th.server.message.view.web.application.WicketApplication;
import com.thoughtworks.xstream.XStream;

//@MountPath(path = "/ws/findById")
//@MountMixedParam(parameterNames={"messageId"})
public class FindByIdWS extends GenericWS {

	public FindByIdWS(PageParameters parameters) {
		super(parameters, new MessageXStreamFactory());
		// TODO Auto-generated constructor stub
	}

	public void	doExecute(PageParameters parameters){
		long teamId = parameters.getLong("messageId");
		
		MessageService service = WicketApplication.get().getMessageService();
		try {
			MessageTO teamTO = service.find(teamId);
			
			XStream xf = xStreamFactory.createXStream();
			this.selement = xf.toXML(teamTO);
//			this.element = TOToXMLConversor.toXML(teamTO);
		} catch (InstanceNotFoundException e) {
			System.out.println("IOIO : " + e.getMessage());
		}
	}

}
