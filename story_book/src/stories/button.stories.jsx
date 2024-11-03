import React from 'react';
import Button from '../components/button';

export default {
  title: 'Example/Button',
  component: Button,
};

const Template = (args) => <Button {...args} />;

export const Primary = Template.bind({});
Primary.args = {
  label: 'Primary Button',
  type: 'primary',  // Set type as 'primary'
  onClick: () => alert('Primary Button Clicked!'),
};

export const Secondary = Template.bind({});
Secondary.args = {
  label: 'Secondary Button',
  type: 'secondary',  // Set type as 'secondary'
  onClick: () => alert('Secondary Button Clicked!'),
};
