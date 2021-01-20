import React, { useState } from 'react';

// useState ==> hook
// state management

function Bottle() {
  const [num1, setNum1] = useState('');
  const [num2, setNum2] = useState('');
  const [Sum, setSum] = useState(0);

  const OnClickAdd = () => {
    setSum(parseInt(num1) + parseInt(num2));
  };


  return (
      
    <div>
        <h3> Simple Add</h3>
      <input value={num1} onChange={(e) => {setNum1(e.target.value);} }></input>
      <input value={num2} onChange={(e) => {setNum2(e.target.value);}}></input>
      <br></br>
      <button onClick={OnClickAdd}>ADD</button>
      <p>{Sum}</p>
      
    </div>
  );
}

export default Bottle;