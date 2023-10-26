import React, { Component } from 'react';
import './App.css';
import axios from "axios";

class App extends Component {
  state = {
    searchterm: '',
    d_none: "d_none",
    contents: []
  };

  inputClick = (e) => {
    e.stopPropagation();
    e.preventDefault();
    this.setState({
      searchterm: "",
      d_none: "d_none",
      contents: []
    });
    if (this.state.searchterm === '') {
      document.getElementsByClassName('v-container')[0].style.background = '#6c6c6c';
      this.setState({ contents: [] });
    }
    else {
      document.getElementsByClassName('v-container')[0].style.background = '#ffffff';
    }
  }

  handleChange = async (event) => {
    event.stopPropagation();
    event.preventDefault();
    //e.stopPropagation();
    // inputdaki değer her değiştiğinde stete'miz update oluyor
    console.log('Handle');
    this.setState({ searchterm: event.target.value });
    let term = this.state.searchterm;
    if (this.state.searchterm.length <= 1) {
      console.log('Boş');
      this.setState({ contents: [] });
      document.getElementsByClassName('v-container')[0].style.background = '#6c6c6c';
      return;
    }
    console.log('Boş değil');
    document.getElementsByClassName('v-container')[0].style.background = '#ffffff';
    const response = await axios.get(`http://localhost:8080/search/stream?term=${term}`);
    const listdata = await response.data;
    this.setState({ contents: listdata.data });
  }

  postUsers = async (e) => {
    e.stopPropagation();
    // başka sayfaya yönledirme işlemi ulmasın diye preventDefault kullandık(submit durumu için)
    e.preventDefault();
    // State deki searhterm değerini bir değişkene atadık url ye this.state.searhterm yazmamamk için
    let term = this.state.searchterm
    const response = await axios.get(`http://localhost:8080/search/stream?term=${term}`);
    const listdata = await response.data;
    const listdata1 = listdata.data;
    console.log("Buton ile gelen cevap ", listdata);
    this.setState({ searchterm: "" });
    this.setState({ d_none: 'd_none' });
    this.setState({ contents: [] });
    // API end pointine get isteği bulunduk ve ordan gelen değeri consola yazdırdık f12 ile gelen değeri görebiliriz
    /*fetch(`http://localhost:8080/search/stream?term=${term}`)
      .then(response => response.json())
      .then(data => console.log("response data:", data));*/
    // istek gittikden sonra searchstate "" boş yaptık
    //this.setState({ searhterm: "" })
  }
  render() {
    return (
      <div className="v-container">
        <div className="search">
          <input type="text"
            id="name"
            name="searchterm"
            
            onChange={this.handleChange}
            onClick={this.inputClick}
            className="searchTerm"
            placeholder="Search" />
          <button onClick={this.postUsers} className="searchButton">
            <i className="fa fa-search"></i>
          </button>
        </div>
        <div className={`titles ${this.state.d_none}`}>
          <ul>
            {
              this.state.contents.length > 0 ? this.state.contents.map((content, index) =>
                <li key={index} onClick={() => this.setState({ searhterm: content.title })}> {content.title}</li>
              )
                : ""
            }
          </ul>
        </div>
      </div>
    );
  }
}

export default App;