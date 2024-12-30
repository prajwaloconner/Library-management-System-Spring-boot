package com.prajwal.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prajwal.lms.entities.Member;
import com.prajwal.lms.entities.repos.MemberRepo;

@Controller
public class MemberController {

	@Autowired
	MemberRepo m;

	@GetMapping("/members")
	public ModelAndView findall() {
		ModelAndView view = new ModelAndView("members");
		List<Member> all = m.findAll();
		view.addObject("members", all);
		return view;
	}

	@GetMapping("/member/new")
	public ModelAndView reg() {
		ModelAndView view = new ModelAndView("create_member");
		Member m1 = new Member();
		view.addObject("member", m1);
		return view;
	}

	@PostMapping("/members")
	public ModelAndView savemem(Member member) {
		m.save(member);
		ModelAndView m2 = new ModelAndView("redirect:/members");
		return m2;
	}

	@GetMapping("/member/{id}")
	public ModelAndView update(@PathVariable("id") long id) {
		ModelAndView m1 = new ModelAndView("update_member");
		Member byId = m.findById(id).get();
		m1.addObject("member", byId);
		return m1;
	}

	@PostMapping("/member/update")
	public ModelAndView updated(Member m1) {
		m.save(m1);
		ModelAndView m2 = new ModelAndView("redirect:/members");
		return m2;
	}

}
