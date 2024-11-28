import React, { useState } from 'react';

const StateHookExample: React.FC = () => {
    const white: string = '#ffffff';
    const black: string = '#000000';
    const [isWhite, setIsWhite] = useState<boolean>(true);
    const [hello, setHello] = useState<string>('');

    return (
        <div style={{ backgroundColor: isWhite ? white : black }}>
            <button onClick={() => setIsWhite((prevState) => !prevState)}>
                Toggle background
            </button>
            <p style={{ color: !isWhite ? white : black }}>{hello}</p>
            <button onClick={() => setHello('Hello!')}>Say hello</button>
        </div>
    );
};

export default StateHookExample;
