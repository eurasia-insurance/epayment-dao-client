package com.lapsa.kkb.dao;

import javax.ejb.Local;

import com.lapsa.kkb.core.KKBOrder;

import tech.lapsa.patterns.dao.GeneralDAO;

@Local
public interface KKBOrderDAO extends GeneralDAO<KKBOrder, String> {
}
