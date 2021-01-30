import React, { Component } from 'react';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import thunk from 'redux-thunk';

import Counter from './containers/Counter/Counter';
import counterReducer from './store/reducers/counter';
import resultsReducer from './store/reducers/result';

const logger = store => {
  return next => {
    return action => {
      console.log('[MiddleWare] Dispatching', action);
      const res = next(action);
      console.log('[MiddleWare] next state', store.getState());
      return res;
    }
  }
}

const store = createStore(combineReducers({
  ctr: counterReducer,
  res: resultsReducer
}), applyMiddleware(logger, thunk));

class AppRedux extends Component {
  render() {
    return (
      <Provider store={store}>
        <div style={{ textAlign: 'center' }}>
          <Counter />
        </div>
      </Provider>
    );
  }
}

export default AppRedux;
