import React, { useState, useEffect } from 'react';

const UseEffectExample: React.FC = () => {
    const [count, setCount] = useState<number>(0);
    const [data, setData] = useState<string[]>([]);

    // This useEffect runs after every render
    useEffect(() => {
        console.log(`The count is now: ${count}`);
    }, [count]); // Runs the effect whenever `count` changes

    // This useEffect fetches data on component mount
    useEffect(() => {
        const fetchData = async () => {
            // Simulate API call
            const response = ['Item 1', 'Item 2', 'Item 3'];
            setData(response);
        };
        
        fetchData();
    }, []); // Empty dependency array makes this run once on mount

    return (
        <div>
            <h1>useEffect Example</h1>
            <p>Count: {count}</p>
            <button onClick={() => setCount(count + 1)}>Increase Count</button>

            <h2>Fetched Data:</h2>
            <ul>
                {data.map((item, index) => (
                    <li key={index}>{item}</li>
                ))}
            </ul>
        </div>
    );
};

export default UseEffectExample;
