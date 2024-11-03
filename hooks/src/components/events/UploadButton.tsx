import React from 'react';
import Button from './Button';

const UploadButton: React.FC = () => {
  return <Button onClick={() => alert('Uploading!')}>Upload Image</Button>;
};

export default UploadButton;
