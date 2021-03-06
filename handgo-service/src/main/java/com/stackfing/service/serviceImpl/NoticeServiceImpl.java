package com.stackfing.service.serviceImpl;

import com.stackfing.service.dao.NoticeDao;
import com.stackfing.common.exception.HandgoException;
import com.stackfing.service.NoticeService;
import com.stackfing.common.vo.NoticeVo;
import com.stackfing.pojo.Notice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午10:26 18-1-26
 */

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> getNoticeList() {
		return noticeDao.findAll();
	}

	@Override
	public List<Notice> getNoticeList(Integer page, Integer limit) {
		return noticeDao.findAll(new PageRequest(page - 1, limit)).getContent();
	}

	@Override
	public Notice save(Notice notice) {
		return noticeDao.save(notice);
	}

	@Override
	public int delete(Integer id) {
		//TODO
		return 0;
	}

	@Override
	public Notice save(Integer id, Notice vo) {
		if (null == id) {
			throw new HandgoException("ID 为空");
		}
		if (id != vo.getId()) {
			throw new HandgoException("ID 不一致");
		}
		return noticeDao.save(vo);
	}
}
