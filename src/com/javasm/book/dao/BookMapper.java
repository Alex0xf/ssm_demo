package com.javasm.book.dao;

import java.util.List;

import com.javasm.book.model.Book;

public interface BookMapper {
	int deleteByPrimaryKey(Long bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    
    List<Book> selectBookList();
}