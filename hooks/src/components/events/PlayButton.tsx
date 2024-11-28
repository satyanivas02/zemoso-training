import React from 'react';
import Button from './Button';

interface PlayButtonProps {
  movieName: string;
}

const PlayButton: React.FC<PlayButtonProps> = ({ movieName }) => {
  const handlePlayClick = () => {
    alert(`Playing ${movieName}!`);
  };

  return <Button onClick={handlePlayClick}>Play "{movieName}"</Button>;
};

export default PlayButton;
