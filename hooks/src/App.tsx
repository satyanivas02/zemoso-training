// import { ThemeProvider } from './components/hooks/ThemeProvider';
// import ThemeToggleButton from './components/hooks/ThemeToggleButton';
// import Counter from './components/hooks/Counter';
// import MemoExample from './components/hooks/MemoExample';
// import Counter1 from './components/hooks/Counter1';
// import InputFocus from './components/hooks/InputFocus';
// import Box from './components/hooks/Box';
// import useCounter from './components/hooks/useCounter';
// import Toolbar from './components/events/Toolbar';
// import { Box } from '@mui/material';
// import PlayButton from './components/events/PlayButton';
// import UploadButton from './components/events/UploadButton';
// import AlertButton from './components/events/AlertButton';
import { Container, Box } from '@mui/material';
import SimpleCrud from './components/fetch/SimpleCrud';
import SimpleCrudAxios from './components/fetch/SimpleCrudAxios';
import FormComponent from './components/forms/FormComponent';


const App = () => {
  // const { count, increment, decrement } = useCounter(0);
  return (
    // <ThemeProvider>
    //   <div>
    //     <h1>Welcome to the Themed App!</h1>
    //     <ThemeToggleButton />
    //     <hr />
    //     <h1>Counter App</h1>
    //     <Counter />
    //     <hr />
    //     <h1>React Hooks Example</h1>
    //     <MemoExample />
    //     <hr />
    //     <h1>useCallback Example</h1>
    //     <Counter1 />
    //     <hr />
    //     <h1>useRef Example</h1>
    //     <InputFocus />
    //     <hr />
    //     <h1>useLayoutEffect Example</h1>
    //     <Box />
    //     <hr />
    //     <h1>useCounter(Custom Hook) Example</h1>
    //     <h1>Count: {count}</h1>
    //     <button onClick={increment}>Increment</button>
    //     <button onClick={decrement}>Decrement</button>
    //   </div>
    // </ThemeProvider>


    //Events
    // <Box>
    //   <h1>Event Propagation Example</h1>
    //   <Toolbar />
    //   <h1>Reading Props in Event Handlers</h1>
    //   <AlertButton message="Playing!">Play Movie</AlertButton>
    //   <AlertButton message="Uploading!">Upload Image</AlertButton>
    //   <PlayButton movieName="Kiki's Delivery Service" />
    //   <UploadButton />
    // </Box>


    //fetch API
    <Container sx={{ mt: 4 }}>
      <Box><SimpleCrud /></Box>
      <hr />
      <Box><SimpleCrudAxios /></Box>
      <hr />
      <Box className='App'>
        <h1>Form Example</h1>
        <FormComponent />
      </Box>
    </Container>

  );
};

export default App;
