import React, { useContext } from 'react';

import Ingredients from './components/Ingredients/Ingredients';
import Auth from './components/Auth';
import { AuthContext } from './context/auth-context';

const App = props => {
  const authCtx = useContext(AuthContext);
  if (!authCtx.auth) {
    return <Auth />;
  }
  return <Ingredients />;
};

export default App;
