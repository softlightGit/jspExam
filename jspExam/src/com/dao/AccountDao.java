package com.dao;

import java.util.List;

import com.bean.Account;

public interface AccountDao {
	// 添加
	public int addAccount(Account account);
	// 更新
	public int updateAccount(Account account);
	// 删除
	public int deleteAccount(int id);
	
	// 通过id查询
	public Account findAccountById(int id);
	// 查询
	public List<Account> findAllAccount();
}
