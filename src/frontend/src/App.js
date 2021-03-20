import React, {useState, useEffect, useCallback} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'

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
            <br/>
            <br/>
          <h1>{items.name}</h1>
          <p>{items.price}</p>
          <Dropzone/>
          <br/>
        </div>
    )
  });
}

function Dropzone() {
  const onDrop = useCallback(acceptedFiles => {
      const file = acceptedFiles[0];
      console.log(file);
  }, []);
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
      <div {...getRootProps()}>
        <input {...getInputProps()} />
        {
          isDragActive ?
              <p>Drop your item photo</p> :
              <p>Drag od drop your item photo</p>
        }
      </div>
  )
}

function App() {
  return (
    <div className="App">
      <Item />
    </div>
  );
}

export default App;
