import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './App.css';
import axios from "axios";

class App extends Component {
  constructor(props) {
		super(props);

		this.state = {
      intakes: [],
      rooms: []
		};
  }

  handleSubmit = () => {
    var size = document.getElementById("intake").value;

    axios.post("http://localhost:8081/classroom/createIntake",
    {
      size: size,
      classroomId: -1
    })
  }

  removeIntake = () => {
    var id = document.getElementById("remove").value;

    axios.delete("http://localhost:8081/classroom/deleteIntake/" + id)
  }

  componentDidMount = () => {
    axios.get("http://localhost:8081/classroom/getIntakes")
    .then(response => {
      this.setState({ intakes: response.data });
    })
    axios.get("http://localhost:8081/classroom/getRooms")
    .then(response => {
      this.setState({ rooms: response.data });
    })
  }


  render() {
    const intakes = this.state.intakes.map((item) => (
      <tr>
          <td>intake: {item.intakeId}</td>
          <td>_size: {item.size}</td>
      </tr>
  ));
    const rooms = this.state.rooms.map((item) => (
      <tr>
          <td>classroom: {item.name}</td>
          <td>_capacity: {item.capacity}</td>
      </tr>
  ));
    return (
      <div className="App">
        <form onSubmit={this.handleSubmit}>
          <label>
            Enter intake size:
            <input type="number" id="intake" />
          </label>
          <input type="submit" value="Submit" />
        </form>

        <br/>
        <tbody>
          {intakes}
        </tbody>

        <form onSubmit={this.removeIntake}>
          <label>
            Remove intake by id:
            <input type="number" id="remove" />
          </label>
          <input type="submit" value="Submit" />
        </form>

        <br/>
        available rooms:
        <tbody>
          {rooms}
        </tbody>
      </div>
    );
  }
}

export default App;
