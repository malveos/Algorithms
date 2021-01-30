import React, { useCallback, useReducer, useMemo } from 'react';

import IngredientForm from './IngredientForm';
import IngredientList from './IngredientList';
import ErrorModal from '../UI/ErrorModal';
import Search from './Search';
import useHttp from '../../hooks/https';

const ingreReducer = (currIngredients, action) => {
  switch (action.type) {
    case 'SET':
      return action.ingredients;
    case 'ADD':
      return [...currIngredients, action.newIngr];
    case 'DELETE':
      return currIngredients.filter(i => i.id !== action.id)
    default:
      throw new Error('no option reach here');
  }
}

function Ingredients() {

  const [userIngredients, dispatch] = useReducer(ingreReducer, []);
  //const [ingredients, setIngredients] = useState([]);
  // const [isLoading, setLoading] = useState(false);
  // const [err, setErr] = useState(null);
  const { isLoading, err, data, sendRequest, isSuccess } = useHttp();

  const addIngredientHandler = useCallback(ingr => {
    sendRequest(
      'https://test-project-hooks-95733.firebaseio.com/ingredients.json',
      'POST',
      JSON.stringify(ingr)
    );
    if (isSuccess && data) {
      dispatch({
        type: 'ADD',
        newIngr: ingr
      });
    }
  }, [sendRequest, isSuccess, data]);

  const removeIngredientHandler = useCallback(id => {
    sendRequest(
      `https://test-project-hooks-95733.firebaseio.com/ingredients/${id}.json`,
      'DELETE'
    );
    if (isSuccess) {
      dispatch({
        type: 'DELETE',
        id: id
      })
    }
  }, [sendRequest, isSuccess]);

  const filterIngredients = useCallback(ingr => {
    //setIngredients(ingr);
    dispatch({ type: 'SET', ingredients: ingr });
  }, []);

  const closeError = useCallback(() => {
    //setErr(null);
    //dispatchHttp({ type: 'CLEAR' });
  }, []);

  const ingrList = useMemo(() => {
    return (<IngredientList ingredients={userIngredients} onRemoveItem={removeIngredientHandler} />)
  }, [userIngredients, removeIngredientHandler]);

  return (
    <div className="App">
      {err && <ErrorModal onClose={closeError}>{err}</ErrorModal>}
      <IngredientForm onAddIngredient={addIngredientHandler} loading={isLoading} />
      <section>
        <Search onLoadIngredients={filterIngredients} />
        {ingrList}
      </section>
    </div>
  );
}

export default Ingredients;
