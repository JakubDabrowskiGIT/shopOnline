import React, {useState, useEffect, useCallback} from "react";
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
                {items.id ? <img src={`http://localhost:8080/backend/${items.id}/image/download`} /> : null}
                <h1>{items.name}</h1>
                <p>{items.description}</p>
                <p>{items.price}</p>
                <p>{items.id}</p>
                <Dropzone {...items}/>
                {/*= id = {items.id}*/}
                <br/>
            </div>
        );
    });
};

function Dropzone({id}) {
    const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        console.log(file);

        const formData = new FormData();
        formData.append("file", file);

        axios.post(`http://localhost:8080/backend/${id}/image/upload`, formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }).then(() => {
            console.log("file uploaded successfully");
        }).catch(err => {
            console.log(err);
        });

    }, []);
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop});

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
            <Item/>
        </div>
    );
}

export default App;
