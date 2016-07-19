package com.kenfor.ssm.directive;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.kenfor.ssm.base.MyException;
import com.kenfor.ssm.model.Comment;
import com.kenfor.ssm.service.ICommentService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class CommentListDirective implements TemplateDirectiveModel {

	@Resource
	private ICommentService commentService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取当前留言ID
		Integer msgId = Integer.valueOf(params.get("msgId").toString());
		// 获取当前页
		Integer curPage = Integer.valueOf(params.get("curPage").toString());
		// 获取搜索关键字
		String keyword = params.get("keyword").toString();
		// 获取开始时间
		String startTime = params.get("startTime").toString();
		// 获取结束时间
		String endTime = params.get("endTime").toString();

		try {
			List<Comment> commentList = commentService.getCommentList(msgId,
					curPage, 5, keyword, startTime, endTime);
			PageInfo page = new PageInfo(commentList);
			// 获取总页数
			int pageCount = page.getPages();

			env.setVariable("pageCount", DEFAULT_WRAPPER.wrap(pageCount));
			env.setVariable("curPage", DEFAULT_WRAPPER.wrap(curPage));
			env.setVariable("pageCount", DEFAULT_WRAPPER.wrap(pageCount));
			env.setVariable("keyword", DEFAULT_WRAPPER.wrap(keyword));
			env.setVariable("startTime", DEFAULT_WRAPPER.wrap(startTime));
			env.setVariable("endTime", DEFAULT_WRAPPER.wrap(endTime));
			env.setVariable("commentList", DEFAULT_WRAPPER.wrap(commentList));

			body.render(env.getOut());
		} catch (MyException e) {
			e.printStackTrace();
			env.setVariable("errorMsg", DEFAULT_WRAPPER.wrap(e.getMessage()));
			body.render(env.getOut());
		}
	}

}
