import React from 'react';

interface Props {
  onIncrement: () => void;
}

const IncrementButton: React.FC<Props> = React.memo(({ onIncrement }) => {
  console.log('Button rendered');
  return <button onClick={onIncrement}>Increment</button>;
});

export default IncrementButton;
