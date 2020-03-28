package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {

		return items.stream().mapToDouble(item -> {
			Optional<Product> product = productRepository.findById(item.getProductId());
			final double valueCalculated = product.get().getValue() * item.getQuantity();
			if (product.get().getIsSale()) return valueCalculated - 0.2 * valueCalculated;
			return valueCalculated;
		}).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {

		return ids.stream().map(id -> {
			Optional<Product> product = productRepository.findById(id);
			return product;
		})
		.filter(Optional::isPresent)
		.map(Optional::get)
		.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {

		return orders.stream()
				.mapToDouble(orderItems -> calculateOrderValue(orderItems)).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().map( id -> {
			Optional<Product> product = productRepository.findById(id);
			return product;
		})
		.filter(Optional::isPresent)
		.map(Optional::get)
		.collect(Collectors.groupingBy(Product::getIsSale));
	}

}