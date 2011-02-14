package com.jpizarro.th.server.message.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.message.entity.MessageTO;
import com.jpizarro.th.lib.message.util.MessageRestURL;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.util.ResourceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.message.model.service.MessageService;

@Controller
@RequestMapping(MessageRestURL.ENTITY)
public class MessageController implements GenericController<MessageTO, Long>{
	@Autowired
	private MessageService messageService;

	private String XML_VIEW_NAME = "xmlView";
	
	@RequestMapping(method=RequestMethod.GET, value=MessageRestURL.ENTITY_ID)
	@ResponseBody
	public MessageTO getEntity(@PathVariable Long id) {
		MessageTO to = null;
		try {
			to = messageService.find(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
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
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public MessageTO addEntity(@RequestBody MessageTO body) {
		MessageTO msg = null;
		try {
			msg = messageService.create( body );
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"users", body);
	}

	@Override
	@RequestMapping(value=MessageRestURL.ENTITY_ID, method=RequestMethod.PUT)
	@ResponseBody
	public MessageTO updateEntity(@PathVariable Long id, @RequestBody MessageTO entity) {
		entity.setMessageId(id);
		try {
			return messageService.update(entity);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		}
//		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=MessageRestURL.ENTITY_ID)
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			messageService.remove(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			ret = false;
			throw new ResourceNotFoundException();
		}
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"team", ret);
	}
}
