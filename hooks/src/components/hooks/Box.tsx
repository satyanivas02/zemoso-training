import React, { useLayoutEffect, useRef, useState } from 'react';

const Box: React.FC = () => {
  const boxRef = useRef<HTMLDivElement>(null);
  const [boxSize, setBoxSize] = useState({ width: 0, height: 0 });

  useLayoutEffect(() => {
    if (boxRef.current) {
      const { width, height } = boxRef.current.getBoundingClientRect();
      setBoxSize({ width, height });
    }
  }, []); 

  return (
    <div>
      <div ref={boxRef} style={{ width: '200px', height: '100px', backgroundColor: 'lightblue' }}>
        I am a box
      </div>
      <p>Box size: {boxSize.width}px wide, {boxSize.height}px tall</p>
    </div>
  );
};

export default Box;
