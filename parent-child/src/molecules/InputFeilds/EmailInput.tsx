import React from 'react';
import CustomInput from '../../atoms/Input/CustomInput';

const EmailInput: React.FC = () => {
  return (
    <CustomInput
      type="email"
      placeholder="Enter your email id"
      icon={<img src="/assets/email.svg" alt="email" />} 
    />
  );
};

export default EmailInput;
