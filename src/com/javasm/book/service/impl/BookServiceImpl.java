package com.javasm.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasm.book.dao.BookMapper;
import com.javasm.book.model.Book;
import com.javasm.book.service.IBookService;


@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	BookMapper bookDao;
	
	@Override
	public List<Book> selectBookList() {
		
		return bookDao.selectBookList();
	}

	
}
