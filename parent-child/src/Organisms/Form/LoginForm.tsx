import React from 'react';
import { Box, Link, Divider } from '@mui/material';
import EmailInput from '../../molecules/InputFeilds/EmailInput';
import PasswordInput from '../../molecules/InputFeilds/PasswordInput';
import CustomButton from '../../atoms/button/CustomButton';
import SocialButtons from '../../molecules/button/SocialButtons';
import CustomTypography from '../../atoms/Typography/CustomTypography';

const LoginForm: React.FC = () => {
    return (
      <Box
        sx={{
          maxWidth: '400px',
          margin: 'auto',
          padding: '2rem',
          borderRadius: '12px',
          textAlign: 'center',
          backgroundColor: '#18181C',
          color: '#E8E7F0',
        }}
      >
        <CustomTypography variant="h4">
          Login to Seeder ✨
        </CustomTypography>
        <CustomTypography variant="body1">
          Enter your mail id and password to login
        </CustomTypography>
  
        <Box mb={2}>
          <EmailInput />
        </Box>
  
        <Box mb={2}>
          <PasswordInput />
        </Box>
  
        <Box mb={2}>
          <Link href="#" underline="none">
            Forgot Password?
          </Link>
        </Box>
  
        <Box mb={3}>
          <CustomButton>Continue</CustomButton>
        </Box>
  
        <Divider>Or</Divider>
  
        <Box mt={3}>
          <SocialButtons />
        </Box>
  
        <Box mt={3}>
          <CustomTypography variant="body1">
            Don’t have an account? <Link href="#">Sign Up</Link>
          </CustomTypography>
        </Box>
      </Box>
    );
  };
  
  export default LoginForm;