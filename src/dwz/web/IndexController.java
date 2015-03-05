package dwz.web;

//import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.book.Book;
import dwz.business.book.BookServiceMgr;
import dwz.business.book.Chapter;
import dwz.business.book.ChapterConditionVO;
import dwz.business.common.IndexServiceMgr;
import dwz.business.common.SessionOper;
import dwz.business.system.Oper;
import dwz.business.system.OperServiceMgr;
import dwz.business.system.Org;
import dwz.business.system.Resource;
import dwz.business.system.Role;

@Controller
public class IndexController extends BaseController {

	// @Inject
	// private User user;

	@Autowired
	private BookServiceMgr bookMgr;
	@Autowired
	private IndexServiceMgr indexServiceMgr;
	@Autowired
	private OperServiceMgr operServiceMgr;

	@RequestMapping("")
	public String index() {
		return "redirect:/chapters";
	}

	@RequestMapping("/books")
	public String books(Model model) {
		System.out.println(getMessage("ui.title"));
		List<Book> bookList = bookMgr.searchBook(null, null, 0, 100);
		model.addAttribute(bookList);
		return "/books";
	}

	@RequestMapping("/chapters")
	public String chapters(ChapterConditionVO vo, Model model) {
		List<Chapter> chapters = bookMgr.searchChapters(vo);

		model.addAttribute("chapters", chapters);

		return "/chapters";
	}

	@RequestMapping("/chapter/{chapterId}")
	public String chapter(@PathVariable("chapterId") int chapterId, Model model) {

		Chapter chapter = bookMgr.getChapter(chapterId);
		Book book = bookMgr.getBook(chapter.getBookId());
		model.addAttribute(chapter);
		model.addAttribute(book);

		return "/chapter";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		return "/login";
	}

	@RequestMapping("/login_dialog")
	public String login_dialog(Model model) {
		return "/login_dialog";
	}

	@RequestMapping("/doLogin")
	public String doLogin(Oper oper, Model model, HttpServletRequest request) {
		if (StringUtils.isEmpty(oper.getUserName())) {
			model.addAttribute("message", "请输入用户名！");
			model.addAttribute("oper", oper);
			return "/login";
		}
		if (StringUtils.isEmpty(oper.getPasswd())) {
			model.addAttribute("message", "请输入密码！");
			model.addAttribute("oper", oper);
			return "/login";
		}
		if (StringUtils.isEmpty(oper.getKaptcha())) {
			model.addAttribute("message", "请输入验证码！");
			model.addAttribute("oper", oper);
			return "/login";
		}
		Object sessionCode = request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (!oper.getKaptcha().equalsIgnoreCase(sessionCode.toString())) {
			model.addAttribute("message", "验证码错误！");
			model.addAttribute("oper", oper);
			return "/login";
		}

		Oper boOper = indexServiceMgr.getOperByLogin(oper);
		if (boOper.getSysOper() == null) {
			model.addAttribute("message", "用户名或密码错误！");
			model.addAttribute("oper", oper);
			return "/login";
		} else {
			if ("0".equals(boOper.getStatus())) {
				model.addAttribute("message", "此账户已停用！");
				model.addAttribute("oper", oper);
				return "/login";
			}
		}
		boolean superAdmin = false;
		List<Role> roleList = indexServiceMgr.findRoleByOperId(boOper
				.getOperId());
		for (Role role : roleList) {
			if ("超级管理员".equals(role.getRoleName())) {
				superAdmin = true;
				break;
			}
		}

		Org org = indexServiceMgr.getOrg(boOper.getOrgId());

		SessionOper sessionOper = new SessionOper();
		sessionOper.setOrgId(org.getOrgId());
		sessionOper.setOrgName(org.getOrgName());
		sessionOper.setEngName(org.getEngName());
		sessionOper.setTel(org.getTel());
		sessionOper.setFax(org.getFax());
		sessionOper.setAddress(org.getAddress());
		sessionOper.setEngAddress(org.getEngAddress());
		sessionOper.setLogo(org.getLogo());
		sessionOper.setOperId(boOper.getOperId());
		sessionOper.setUserName(boOper.getUserName());
		sessionOper.setSuperAdmin(superAdmin);
		request.getSession().setAttribute("sessionOper", sessionOper);

		return "redirect:/admin";
	}

	@RequestMapping("/doLogin_dialog")
	public ModelAndView doLogin_dialog(Oper oper, Model model,
			HttpServletRequest request) {
		if (StringUtils.isEmpty(oper.getUserName())) {
			return this.ajaxDoneError("请输入用户名！");
		}
		if (StringUtils.isEmpty(oper.getPasswd())) {
			return this.ajaxDoneError("请输入密码！");
		}
		Oper boOper = indexServiceMgr.getOperByLogin(oper);
		if (boOper.getSysOper() == null) {
			return this.ajaxDoneError("用户名或密码错误！");
		} else {
			if ("0".equals(boOper.getStatus())) {
				return this.ajaxDoneError("此帐号已停用！");
			}
		}

		Org org = indexServiceMgr.getOrg(boOper.getOrgId());
		boolean superAdmin = false;
		List<Role> roleList = indexServiceMgr.findRoleByOperId(boOper
				.getOperId());
		for (Role role : roleList) {
			if ("超级管理员".equals(role.getRoleName())) {
				superAdmin = true;
				break;
			}
		}

		SessionOper sessionOper = new SessionOper();
		sessionOper.setOrgId(org.getOrgId());
		sessionOper.setOrgName(org.getOrgName());
		sessionOper.setEngName(org.getEngName());
		sessionOper.setTel(org.getTel());
		sessionOper.setFax(org.getFax());
		sessionOper.setAddress(org.getAddress());
		sessionOper.setEngAddress(org.getEngAddress());
		sessionOper.setLogo(org.getLogo());
		sessionOper.setOperId(boOper.getOperId());
		sessionOper.setUserName(boOper.getUserName());
		sessionOper.setSuperAdmin(superAdmin);
		request.getSession().setAttribute("sessionOper", sessionOper);

		Set<String> resourceUrlSet = new HashSet<String>();

		List<Resource> tempList = indexServiceMgr.findResourceByOperId(this
				.getSessionOper().getOperId());
		for (Resource resource : tempList) {
			if (!StringUtils.isBlank(resource.getResourceUrl())) {
				resourceUrlSet.add(resource.getResourceUrl());
			}
		}

		request.getSession().setAttribute("resourceUrlSet", resourceUrlSet);

		return ajaxDoneSuccess("登录成功");
	}

	@RequestMapping("admin")
	public String admin(HttpServletRequest request) {

		List<Resource> resourceList = new ArrayList<Resource>();
		Set<String> resourceUrlSet = new HashSet<String>();

		List<Resource> tempList = indexServiceMgr.findResourceByOperId(this
				.getSessionOper().getOperId());
		// 组装一级菜单
		for (Resource resource : tempList) {
			if (resource.getParentResourceId() == 0) {
				resourceList.add(resource);

				if (!StringUtils.isBlank(resource.getResourceUrl())) {
					resourceUrlSet.add(resource.getResourceUrl());
				}
			}
		}

		// 组装二级菜单
		for (Resource firstLevel : resourceList) {

			for (Resource resource : tempList) {
				if (resource.getParentResourceId().equals(
						firstLevel.getResourceId())) {
					firstLevel.getResourceList().add(resource);

					if (!StringUtils.isBlank(resource.getResourceUrl())) {
						resourceUrlSet.add(resource.getResourceUrl());
					}
				}
			}

		}

		// 组装三级菜单
		for (Resource firstLevel : resourceList) {

			for (Resource secondLevel : firstLevel.getResourceList()) {

				for (Resource resource : tempList) {
					if (resource.getParentResourceId().equals(
							secondLevel.getResourceId())) {
						secondLevel.getResourceList().add(resource);

						if (!StringUtils.isBlank(resource.getResourceUrl())) {
							resourceUrlSet.add(resource.getResourceUrl());
						}
					}
				}

			}

		}

		request.getSession().setAttribute("resourceUrlSet", resourceUrlSet);
		request.setAttribute("resourceList", resourceList);

		return "/admin";
	}

	@RequestMapping("/info")
	public String info(Model model, HttpServletRequest request) {

		Oper oper = operServiceMgr.getOper(getSessionOper().getOperId());
		request.setAttribute("oper", oper);

		return "/info";
	}

	@SystemLog("首页：更新了个人信息")
	@RequestMapping(value = "/updInfo", method = RequestMethod.POST)
	public ModelAndView updInfo(Oper oper) {
		operServiceMgr.upd(oper);
		return ajaxDoneSuccess("个人资料修改成功！");
	}

	@RequestMapping("/passwd")
	public String passwd(Model model, HttpServletRequest request) {
		return "/passwd";
	}

	@SystemLog("首页：修改了密码")
	@RequestMapping(value = "/updPasswd", method = RequestMethod.POST)
	public ModelAndView updPwd(Oper oper) {
		oper.setOperId(getSessionOper().getOperId());
		if (!operServiceMgr.checkPasswd(oper)) {
			return ajaxDoneError("旧密码错误！");
		}
		operServiceMgr.updPwd(oper);
		return ajaxDoneSuccess("修改成功,新密码为" + oper.getNewPasswd());
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("sessionOper", null);
		return "redirect:/login";
	}
}