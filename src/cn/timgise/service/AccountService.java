/**
 *    Copyright 2010-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cn.timgise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.timgise.domain.Account;
import cn.timgise.persistence.AccountMapper;

/**
 * @author Eduardo Macarron
 * 
 */
@Service
public class AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	public Account getAccount(String username) {
		return accountMapper.getAccountByUsername(username);
	}

	public Account getAccount(String username, String password) {
		return accountMapper
				.getAccountByUsernameAndPassword(username, password);
	}

	public void insertAccount(Account account) {
		accountMapper.insertAccount(account);
		accountMapper.insertProfile(account);
		accountMapper.insertSignon(account);
	}

	public void updateAccount(Account account) {
		accountMapper.updateAccount(account);
		accountMapper.updateProfile(account);

		if (account.getPassword() != null && account.getPassword().length() > 0) {
			accountMapper.updateSignon(account);
		}
	}

}
