/*
        File : OOP3200_F2021_ICE 9
        Created by: Tom Tsiliopoulos
        Edited by: Soumya Narayanamandiram Narayananunni
        Date: November 18, 2021
 */

package ca.durhamcollege;

import org.jetbrains.annotations.NotNull;

public class Vector2D
{
    //Private instance variables
    private float x;
    private float y;

    //Public Properties(Mutators& Accessors)
    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void Set(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    //Constructors

    Vector2D()
    {
        Set(Vector2D.zero());
    }

    private void Set(Vector2D zero) {
    }

    Vector2D(float x, float y)
    {
        Set(x,y);
    }
    Vector2D(@NotNull Vector2D vector)
    {
        Set(vector.getX(), vector.getY());
    }

    //Private Methods
    //Public Methods

    public void add(Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }
    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
    }

    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }

    public void divide(final Vector2D rhs)
    {
        this.setX(this.getX() / rhs.getX());
        this.setY(this.getY() / rhs.getY());
    }

    public boolean equals(final Vector2D rhs)
    {
        return ((getX() == rhs.getX()) && (getY() == rhs.getY()));
    }
    public float getMagnitude()
    {
        return (float)(Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()));
    }

    public float getSqrMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY());
    }

    public void setScale(final float scale)
    {
        this.Set(this.getX() * scale, this.getY() * scale);
    }

    public void setScale(final Vector2D scale)
    {
        this.Set(this.getX() * scale.x, this.getY() * scale.y);
    }

    public void normalize()
    {
        final var magnitude = this.getMagnitude();
        if ((double)(magnitude) > 9.99999974737875E-06)
        {
            Set(getX() / magnitude, getY() / magnitude);
        }
        else
        {
            Set(Vector2D.zero());
        }
    }

    public Vector2D getNormalized()
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    @Override
    public String toString()
    {
        return "{" + x + ", " + y + "}";
    }

    //Static methods

    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }

    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }

    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }

    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }

    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        // clamp t between 0.0 and 1.0
        if ((double)(t) < 0.0)
        {
            t = 0.0f;
        }
        if ((double)(t) > 1.0)
        {
            t = 1.0f;
        }

        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    public static float distance(final Vector2D a, final Vector2D b)
    {
        final var delta_x = (double)(b.getX()) - (double)(a.getX());
        final var delta_y = (double)(b.getY()) - (double)(a.getY());

        return (float)(Math.sqrt(delta_x * delta_x + delta_y * delta_y));
    }
}
