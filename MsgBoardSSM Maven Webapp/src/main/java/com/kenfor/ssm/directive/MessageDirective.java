package com.kenfor.ssm.directive;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Message;
import com.kenfor.ssm.service.IMessageService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class MessageDirective implements TemplateDirectiveModel {

	@Resource
	private IMessageService messageService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取模版传入参数
		Integer msgId = Integer.valueOf(params.get("msgId").toString());

		try {
			Message message = messageService.getMessageById(msgId);
			env.setVariable("message", DEFAULT_WRAPPER.wrap(message));
			body.render(env.getOut());
		} catch (MyException e) {
			e.printStackTrace();
			env.setVariable("errorMsg", DEFAULT_WRAPPER.wrap(e.getMessage()));
			body.render(env.getOut());
		}
	}
}
