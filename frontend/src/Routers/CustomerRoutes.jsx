import React from "react";
import { Route, Routes } from "react-router-dom";
import HomePage from "../customer/pages/HomePage/HomePage";
import Cart from "../customer/components/Cart/Cart";
import Navbar from "../customer/components/Navbar/Navbar";
import Footer from "../customer/components/Footer/Footer";
import Product from "../customer/components/Product/Product";
import ProductDetails from "../customer/components/ProductDetails/ProductDetails";
import Checkout from "../customer/components/Checkout/Checkout";
import Order from "../customer/components/Order/Order";
import OrderDetails from "../customer/components/OrderDetails/OrderDetails";

const CustomerRoutes = () => {
  return (
    <div>
      <div>
        <Navbar />
      </div>
      <Routes>

      <Route path="/login" element={<HomePage />}></Route>
      <Route path="/register" element={<HomePage />}></Route>

        <Route path="/" element={<HomePage />}></Route>
        <Route path="/cart" element={<Cart />}></Route>
        <Route path="/:lavelOne/:lavelTwo/:lavelThree" element={<Product/>}></Route>
        <Route path="/product/:productId" element={<ProductDetails/>}></Route>
        <Route path="checkout" element={<Checkout/>}></Route>
        <Route path="account/order" element={<Order/>}></Route>
        <Route path="account/order/:orderId" element={<OrderDetails/>}></Route>
        {/* <Order/> */}
        {/* <OrderDetails/> */}
      </Routes>
      <div>
        <Footer />
      </div>
    </div>
  );
};

export default CustomerRoutes;
