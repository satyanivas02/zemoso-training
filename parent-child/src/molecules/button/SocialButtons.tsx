import React from 'react';
import { Box } from '@mui/material';
import SocialButton from '../../atoms/button/SocialButton';

const SocialButtons: React.FC = () => {
  return (
    <div>
      <Box display="flex" justifyContent="space-around">
        <Box>
            <SocialButton icon={<img src="/assets/google.svg" alt="google" />} label="Google"/>
        </Box>
        <Box >
            <SocialButton icon={<img src="/assets/stripe.svg" alt="stripe" />} label="Stripe" />
        </Box>
        <Box>
            <SocialButton icon={<img src="/assets/xero.svg" alt="xero" />} label="Xero" />
        </Box>
     </Box>
    </div>
  );
};

export default SocialButtons;

