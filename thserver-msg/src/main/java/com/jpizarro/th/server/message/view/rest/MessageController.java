package com.jpizarro.th.server.message.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.message.model.service.MessageService;

@Controller
@RequestMapping("/messages")
public class MessageController implements GenericController<MessageTO, Long>{
	@Autowired
	private MessageService messageService;
	@Autowired
	private RestClient restClient;
	private String XML_VIEW_NAME = "xmlView";
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public MessageTO getEntity(@PathVariable Long id) {
		MessageTO to = null;
		try {
			to = messageService.find(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"team", to);
	}
	
	@Override
	public List<MessageTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addEntity(@RequestBody String body) {
		// TODO Auto-generated method stub
		try {
			MessageTO teamTO = new MessageTO();
//			teamTO.setTeamId(16);
//			teamTO.setName("dddd");
			messageService.create( teamTO );
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"users", body);
	}

	@Override
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public MessageTO updateEntity(@PathVariable Long id, @RequestBody MessageTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			messageService.remove(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			ret = false;
		}
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"team", ret);
	}

	@Override
	public MessageTO addEntity(MessageTO body) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}/test")
	@ResponseBody
	public MessageTO restTest(@PathVariable Long id) {
		MessageTO to = null;
		to = restClient.getEntity(id);
		return to;
	}

}
