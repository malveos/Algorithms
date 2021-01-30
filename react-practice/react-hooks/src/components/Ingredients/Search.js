import React, { useEffect, useState, useRef } from 'react';

import Card from '../UI/Card';
import LoadingIndicator from '../UI/LoadingIndicator';
import useHttp from '../../hooks/https';
import './Search.css';

const Search = React.memo(props => {
  const [filter, setFilter] = useState('');
  const [isLoading, setLoading] = useState(false);
  const { onLoadIngredients } = props;
  const ipRef = useRef();
  //const { isLoading, err, data, sendRequest, isSuccess } = useHttp();

  useEffect(() => {
    setLoading(true);
    const timer = setTimeout(() => {
      if (filter === ipRef.current.value) {
        const queryParam = filter.length === 0 ? '' : `?orderBy="title"&equalTo="${filter}"`;
        fetch('https://test-project-hooks-95733.firebaseio.com/ingredients.json' + queryParam)
          .then(response => response.json())
          .then(data => {
            setLoading(false);
            const ingrs = [];
            for (const k in data) {
              ingrs.push({
                id: k,
                title: data[k].title,
                amount: data[k].amount
              });
            }
            onLoadIngredients(ingrs);
          })
      }
    }, 500);
    return () => {
      clearTimeout(timer);
    }
  }, [filter, onLoadIngredients, ipRef]);

  return (
    <section className="search">
      <Card>
        <div className="search-input">
          <label>Filter by Title</label>
          <input
            ref={ipRef}
            type="text"
            value={filter}
            onChange={(event) => setFilter(event.target.value)} />
            {isLoading && <LoadingIndicator />}
        </div>        
      </Card>
    </section>
  );
});

export default Search;
