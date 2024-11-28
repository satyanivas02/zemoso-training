import React, { useState, useCallback } from 'react';
import IncrementButton from './IncrementButton';

const Counter: React.FC = () => {
  const [count, setCount] = useState(0);


  const increment = useCallback(() => {
    setCount((prevCount) => prevCount + 1);
  }, []);

  return (
    <div>
      <h1>Counter: {count}</h1>
      <IncrementButton onIncrement={increment} />
    </div>
  );
};

export default Counter;
