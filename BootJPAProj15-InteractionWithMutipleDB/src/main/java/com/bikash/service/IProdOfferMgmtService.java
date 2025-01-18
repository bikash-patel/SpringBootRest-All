package com.bikash.service;

import java.util.List;

import com.bikash.entity.offeres.Offeres;
import com.bikash.entity.product.Product;

public interface IProdOfferMgmtService {
	public String registerProdAndOffers(Product prod,Offeres offer);
	public List<Product> getAllProduct();
	public List<Offeres> getAllOfferes();
}
