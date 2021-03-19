import React, {useState, useEffect} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";

const Item = () => {

  const fetchItems = () => {
    axios.get("http://localhost:8080/backend").then(res => {
      console.log(res);
    });
  }

  useEffect(() => {
    fetchItems();
  }, []);

  return "Hello"
}

function App() {
  return (
    <div className="App">
      <Item />
    </div>
  );
}

export default App;
