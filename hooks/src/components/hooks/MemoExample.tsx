import React, { useState, useMemo } from 'react';

const MemoExample: React.FC = () => {
  const [count, setCount] = useState(0);
  const [otherState, setOtherState] = useState(0);

  const memoizedValue = useMemo(() => {
    console.log('Calculating expensive value...');
    return count * 2;
  }, [count]);

  return (
    <div>
      <h1>useMemo Example</h1>
      <p>Count: {count}</p>
      <p>Memoized Value: {memoizedValue}</p>
      <button onClick={() => setCount(count + 1)}>Increment Count</button>
      <button onClick={() => setOtherState(otherState + 1)}>Change Other State</button>
    </div>
  );
};

export default MemoExample;
