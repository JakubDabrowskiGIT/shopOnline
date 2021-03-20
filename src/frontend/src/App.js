import React, {useState, useEffect} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";

const Item = () => {

  const [items, setItems] = useState([]);

  const fetchItems = () => {
    axios.get("http://localhost:8080/backend").then(res => {
      console.log(res);
      const data = res.data;
      setItems(res.data);
    });
  }

  useEffect(() => {
    fetchItems();
  }, []);

  return items.map((items, index) => {
    return (
        <div key={index}>
          <h1>{items.name}</h1>
          <p>{items.price}</p>
        </div>
    )
  });
}

function App() {
  return (
    <div className="App">
      <Item />
    </div>
  );
}

export default App;
