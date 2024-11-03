import React from 'react';
import Heading from '../components/header';

export default {
    title: 'Example/Heading',
    component: Heading,
};
  
const Template = (args) => <Heading {...args} />;
  
export const Primary = Template.bind({});
Primary.args = {
    text: 'My name is Satya',
    boldPart: 'My name is',  
};
  
export const Secondary = Template.bind({});
  Secondary.args = {
    text: 'My name is Satya',
    boldPart: 'Satya', 
};
