## MOXY (MVP)
MVP pattern  is a way of separating responsibilities in application code.

## Capabilities 

Presenter stay alive when Activity recreated(it simplify work with multithreading)
Automatically restore all that user see when Activity recreated
Capability to changes of many Views from one Presenter

The following annotations are available:
@InjectPresenter - annotation for Presenter lifecycle management
@InjectViewState - annotation for binding ViewState to Presenter
@StateStrategyType - annotation to control the strategy of adding and removing a command from the command queue in ViewState


