package com.app.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.app.mvc.domain.ProductVO;
import com.app.mvc.mybatis.config.MyBatisConfiguration;

public class ProductDAO {
	private SqlSession sqlSession;
	
	public ProductDAO() {
		sqlSession = MyBatisConfiguration.getSqlSessionFactory().openSession(true);
	}
	
//	상품 추가
	public void insert(ProductVO productVO) {
		sqlSession.insert("product.insert", productVO);
	}
	
//	상품 전체 조회
	public List<ProductVO> selectAll(){
		return sqlSession.selectList("product.selectAll");
	}
}
