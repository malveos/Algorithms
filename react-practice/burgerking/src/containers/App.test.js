import React from 'react';
import ReactDOM from 'react-dom';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';

import App from './App';

it('renders without crashing', () => {
  const div = document.createElement('div');
  //const Elem = new ;
  ReactDOM.render(withRouter(connect(null,null)(App)), div);
  ReactDOM.unmountComponentAtNode(div);
});
