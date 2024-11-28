import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { RootState, AppDispatch } from './redux/store';
import { increment, decrement, reset, incrementByAmount } from './features/counter/counterSlice';
import { Button, TextField, Typography, Container, Box } from '@mui/material';

const App: React.FC = () => {
  const [amount, setAmount] = useState<number>(0);
  
  const count = useSelector((state: RootState) => state.counter.value);
  const dispatch = useDispatch<AppDispatch>();

  const handleIncrement = () => dispatch(increment());
  const handleDecrement = () => dispatch(decrement());
  const handleReset = () => dispatch(reset());
  const handleIncrementByAmount = () => dispatch(incrementByAmount(amount));

  return (
    <Container maxWidth="sm">
      <Box sx={{ textAlign: 'center', mt: 4 }}>
        <Typography variant="h4">Counter</Typography>
        
        <Box sx={{ mt: 2 }}>
          <Button variant="contained" color="primary" onClick={handleIncrement}>+</Button>
          <Typography variant="h6" sx={{ display: 'inline', mx: 2 }}>Count: {count}</Typography>
          <Button variant="contained" color="secondary" onClick={handleDecrement}>-</Button>
        </Box>

        <Box sx={{ mt: 2 }}>
          <Button variant="outlined" onClick={handleReset}>Reset</Button>
        </Box>

        <Box sx={{ mt: 2 }}>
          <TextField
            label="Enter Amount"
            type="number"
            value={amount}
            onChange={(e) => setAmount(Number(e.target.value))}
            fullWidth
          />
          <Button 
            variant="contained"
            color="success"
            onClick={handleIncrementByAmount}
            sx={{ mt: 2 }}
          >
            Increment by Amount
          </Button>
        </Box>
      </Box>
    </Container>
  );
};

export default App;
