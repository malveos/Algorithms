import React, { Component } from 'react';
import { Route, Switch, withRouter, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import Layout from '../hoc/Layout/Layout';
import BurgerBuilder from './BurgerBuilder/BurgerBuilder';
import Logout from '../containers/Auth/Logout/Logout';
import * as actions from '../store/actions/index';
import AsyncComp from '../hoc/asyncComponent/asyncComponent';

const asyncCheckout = AsyncComp(() => {
  return import('../containers/CheckOut/CheckOut');
});

const asyncOrders = AsyncComp(() => {
  return import('../containers/Orders/Orders');
});

const asyncAuth = AsyncComp(() => {
  return import('../containers/Auth/Auth');
});

class App extends Component {

  componentDidMount() {
    this.props.tryAutoSignUp();
  }

  render() {
    let routes = (
      <Switch>
        <Route path="/auth" component={asyncAuth} />
        <Route path="/" component={BurgerBuilder} />
        <Redirect to="/" />
      </Switch>
    );
    if (this.props.isAuthenticated) {
      routes = (
        <Switch><Route path="/checkout" component={asyncCheckout} />
          <Route path="/orders" component={asyncOrders} />
          <Route path="/logout" component={Logout} />
          <Route path="/auth" component={asyncAuth} />
          <Route path="/" component={BurgerBuilder} />
          <Redirect to="/" />
        </Switch>
      );
    }
    return (
      <div>
        <Layout>
          {routes}
        </Layout>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    isAuthenticated: state.auth.token !== null
  };
};

const mapDispatchToProps = dispath => {
  return {
    tryAutoSignUp: () => dispath(actions.authCheckState())
  };
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));