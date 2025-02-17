import React from 'react';

import ProductItem from '../components/Products/ProductItem';
import { useStore } from '../hook-store/store';
import './Products.css';

const Products = props => {
  const state = useStore()[0];
  const productList = state.products;//useContext(ProductContext).products;
  return (
    <ul className="products-list">
      {productList.map(prod => (
        <ProductItem
          key={prod.id}
          id={prod.id}
          title={prod.title}
          description={prod.description}
          isFav={prod.isFavorite}
        />
      ))}
    </ul>
  );
};

export default Products;
