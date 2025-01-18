package com.bikash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bikash.entity.offeres.Offeres;
import com.bikash.entity.product.Product;
import com.bikash.repository.offeres.IRepoOfferes;
import com.bikash.repository.product.IRepoProduct;

@Service
public class ProdOfferMgmtServiceImpl implements IProdOfferMgmtService {

	@Autowired
	private IRepoProduct prodService;
	
	@Autowired
	private IRepoOfferes offerService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String registerProdAndOffers(Product prod, Offeres offer) {
		int id1=prodService.save(prod).getPId();
		int id2=offerService.save(offer).getOId();
		return "Product with Offer details saved with id : "+id1+" and "+id2;
	}
	@Override
	public List<Product> getAllProduct() {
		List<Product> list=prodService.findAll();
		return list;
	}
	@Override
	public List<Offeres> getAllOfferes() {
		List<Offeres> list=offerService.findAll();
		return list;
	}

}
