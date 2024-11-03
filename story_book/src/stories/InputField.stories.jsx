import React, { useState } from 'react';
import InputField from '../components/InputField';

export default {
    title: 'Example/InputField',
    component: InputField,
    argTypes: {
      placeholder: { control: 'text' },
      value: { control: 'text' },
    },
  };
  
  const Template = (args) => (
    <InputField
      {...args}
      onChange={(e) => args.onChange(e.target.value)} 
    />
  );
  
  export const Default = Template.bind({});
  Default.args = {
    placeholder: 'Enter text...',
    value: '',
    onChange: (newValue) => Default.args.value = newValue,
  };
