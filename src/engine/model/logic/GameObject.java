package engine.model.logic;

import java.util.ArrayList;
import java.util.List;

import engine.model.logic.components.LogicComponent;
import engine.model.logic.components.Transform;

import engine.view.render.components.RenderComponent;

public class GameObject {
    private List<LogicComponent> components;
    private GameLogic gameLogic;
    private RenderComponent renderComponent;
    private Transform transform;

    public GameObject() {
        this.components = new ArrayList<>();
        this.transform = new Transform();
    }

    public List<LogicComponent> getComponents() { return this.components; }
    public GameLogic getGameLogic() { return this.gameLogic; }
    public RenderComponent getRenderComponent() { return this.renderComponent; }
    public Transform getTransform() { return this.transform; }

    public void setGameLogic(GameLogic gameLogic) { this.gameLogic = gameLogic; }
    public void setRenderComponent(RenderComponent renderComponent) {
        renderComponent.setGameObject(this);
        this.renderComponent = renderComponent;
    }

    public void addComponent(LogicComponent component) {
        component.setGameObject(this);
        this.components.add(component);
    }
    @Override
    public String toString() {
        String result = transform.toString();
        for (LogicComponent c: components) {
            result += "," + c.toString();
        }
        return result;
    }
    public void update() { this.components.forEach(LogicComponent::update); }
}
